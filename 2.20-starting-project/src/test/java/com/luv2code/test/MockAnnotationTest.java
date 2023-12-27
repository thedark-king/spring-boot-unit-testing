package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @MockBean
    private ApplicationDao mockApplicationDao;

    @Autowired
    private ApplicationService mockApplicationService;


    @BeforeEach
    public void beforeEach() {
        studentOne.setFirstname("Raj");
        studentOne.setLastname("Rajan");
        studentOne.setEmailAddress("rajrajan@gmail.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & verify")
    @Test
    public void assetEqualsTestAddGrades() {
        when(mockApplicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.00);

        assertEquals(100, mockApplicationService.addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()));

        verify(mockApplicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
        verify(mockApplicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @DisplayName("Find gap")
    @Test
    public void assertEqualsTestFindGap() {
        when(mockApplicationDao.findGradePointAverage(studentGrades.getMathGradeResults())).thenReturn(88.31);
        assertEquals(88.31, mockApplicationService.findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Not Null")
    @Test
    public void testAssertNotNull() {
        when(mockApplicationDao.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);
        assertNotNull(mockApplicationService.checkNull(studentOne.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Throw runtime exception")
    @Test
    public void throwRuntimeException() {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");
        doThrow(new RuntimeException()).when(mockApplicationService).checkNull(nullStudent);
        assertThrows(RuntimeException.class, () -> {mockApplicationService.checkNull(nullStudent);});
        verify(mockApplicationService, times(1)).checkNull(nullStudent);
    }


    @DisplayName("Multiple Stubbing")
    @Test
    public void stubbingConsecutiveCalls() {
        CollegeStudent nullStudent = (CollegeStudent) context.getBean("collegeStudent");

        when(mockApplicationDao.checkNull(nullStudent)).thenThrow(new RuntimeException()).thenReturn("Do not throw exception second time");

        assertThrows(RuntimeException.class, () -> mockApplicationService.checkNull(nullStudent));
        assertEquals("Do not throw exception second time", mockApplicationService.checkNull(nullStudent));

        verify(mockApplicationDao, times(2)).checkNull(nullStudent);
    }

}
