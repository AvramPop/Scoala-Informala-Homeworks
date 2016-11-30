package net.vompi;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dani on 11/30/16.
 */
public class StringUtilityTest {
    @Test
    public void stringWithWhitespacesHasThemRemoved(){
        // given
        String string = new String("Dani are multe mere!");
        StringUtility stringUtility = new StringUtility();
        // when
        String correctedString = stringUtility.removeWhitespaces(string);
        // then
        String correctlyFormattedArray = new String("Daniaremultemere!");
        Assert.assertEquals(correctedString, correctlyFormattedArray);
    }

    @Test
    public void stringWithoutWhitespacesStaysUnmodified(){
        // given
        String string = new String("Daniaremultemere!");
        StringUtility stringUtility = new StringUtility();
        // when
        String correctedString = stringUtility.removeWhitespaces(string);
        // then
        String correctlyFormattedArray = new String("Daniaremultemere!");
        Assert.assertEquals(correctedString, correctlyFormattedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWhitespaces_whenEmptyStringUsed_ExceptionIsThrown(){
        String string = new String("");
        StringUtility stringUtility = new StringUtility();
        stringUtility.removeWhitespaces(string);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWhitespaces_whenNullStringUsed_ExceptionIsThrown(){
        String string = null;
        StringUtility stringUtility = new StringUtility();
        stringUtility.removeWhitespaces(string);
    }

    @Test
    public void stringWithDigitsAsWordsHasThemChanged(){
        // given
        String string = new String("I have four apples!");
        StringUtility stringUtility = new StringUtility();
        // when
        String correctedString = stringUtility.convertNumbersInLiteralsFromStringToDigits(string);
        // then
        String correctlyFormattedArray = new String("I have 4 apples!");
        Assert.assertEquals(correctedString, correctlyFormattedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceDigits_whenEmptyStringUsed_ExceptionIsThrown(){
        String string = new String("");
        StringUtility stringUtility = new StringUtility();
        stringUtility.convertNumbersInLiteralsFromStringToDigits(string);
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceDigits_whenNullStringUsed_ExceptionIsThrown(){
        String string = null;
        StringUtility stringUtility = new StringUtility();
        stringUtility.convertNumbersInLiteralsFromStringToDigits(string);
    }

    @Test
    public void stringWithoutDigitsAsWordsRemainsUnchanged(){
        // given
        String string = new String("I have forty-nine apples!");
        StringUtility stringUtility = new StringUtility();
        // when
        String correctedString = stringUtility.convertNumbersInLiteralsFromStringToDigits(string);
        // then
        String correctlyFormattedArray = new String("I have forty-nine apples!");
        Assert.assertEquals(correctedString, correctlyFormattedArray);
    }

    @Test
    public void stringWithAllWordsDigitsAsWordsHasThemChanged(){
        
        String string = new String("Five six SEVEN eiGHt !!");
        StringUtility stringUtility = new StringUtility();

        String correctedString = stringUtility.convertNumbersInLiteralsFromStringToDigits(string);

        String correctlyFormattedArray = new String("5 6 7 8 !!");
        Assert.assertEquals(correctedString, correctlyFormattedArray);
    }
}