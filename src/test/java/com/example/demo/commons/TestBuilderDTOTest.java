package com.example.demo.commons;

import com.demo.employeeDatabase.request.TestBuilderDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBuilderDTOTest {

    @Test
    public void testBuilderWorkingAsExpected() {
        TestBuilderDTO testBuilder  = TestBuilderDTO.builder()
                .build();

        Assert.assertEquals(null, testBuilder.getField1());
        Assert.assertEquals(null, testBuilder.getField2());

        testBuilder = testBuilder.toBuilder().field1("field1").build();
        Assert.assertEquals("field1", testBuilder.getField1());

        testBuilder = testBuilder.toBuilder().field2("field2").build();
        Assert.assertEquals("field2", testBuilder.getField2());
    }
}
