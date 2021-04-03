package org.automation.junit5.tests.parameterized;

import org.automation.junit5.core.CalculatorTestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by shantonu on 4/2/2021
 */
public class TestCSVSources extends CalculatorTestBase {
    @ParameterizedTest
    @CsvFileSource(resources = "/addition.csv",numLinesToSkip = 1)
    public void testCSVfileParameter(String a, String b, String result){
        assertEquals(Double.valueOf(result).doubleValue(),myCal.add(Double.valueOf(a).doubleValue(),Double.valueOf(b).doubleValue()));
    }

    @ParameterizedTest
    @CsvSource({"shantonu,SHANTONU","teSt, TEST","Java,JAVA"})
    public void testCSV(String input, String expected){
        assertEquals(expected,input.toUpperCase());
    }
    @ParameterizedTest
    @CsvSource(value = {"shantonu|SHANTONU","teSt|TEST","Java|JAVA",},delimiter = '|')
    public void testCSVWithDelimiter(String input, String expected){
        assertEquals(expected,input.toUpperCase());
    }


    /***
     * Argument Aggregator
     * @param fullName
     * @param user
     */
    @ParameterizedTest
    @CsvSource({"shantonu kumar sarker, shantonu,kumar,sarker","shantonu sarker, shantonu,,sarker"})
    public void testAggregatedWithCSV(String fullName, @AggregateWith(UserAggregator.class) User user){
        assertEquals(fullName,user.fullName());

    }

    /***
     * Argument Accessor
     * @param accessor
     */
    @ParameterizedTest
    @CsvSource({"shantonu kumar sarker, shantonu,kumar,sarker","shantonu sarker, shantonu,,sarker"})
    public void testArgumentAccessor(ArgumentsAccessor accessor){
        String fullName = accessor.getString(0);
        String fName = accessor.getString(1);
        String mName = accessor.getString(2);
        String lName = accessor.getString(3);
        assertEquals(fullName,new User(fName,mName,lName).fullName());

    }
}