package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Mock
    private ApplicationDao mockApplicationDao;

    @InjectMocks
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


}
