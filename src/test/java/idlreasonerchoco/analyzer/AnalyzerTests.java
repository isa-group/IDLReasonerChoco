package idlreasonerchoco.analyzer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import idlreasonerchoco.configuration.model.IDLException;

class AnalyzerTests {

    @ParameterizedTest
    @ValueSource(strings = {"noParams", "oneParamBoolean", "oneDependencyRequires", "oneDependencyOr", "oneDependencyOnlyOne",
            "oneDependencyAllOrNone", "oneDependencyZeroOrNone", "oneDependencyArithRel", "oneDependencyComplex"})
    void randomValidRequestTest(String operation) throws IDLException {
        Analyzer analyzer = new Analyzer("oas", "./src/test/resources/OAS_test_suite.yaml", "/" + operation, "get");
        Map<String, String> validRequest = analyzer.getRandomRequest();
        assertTrue(analyzer.isValidRequest(validRequest), "The request should be VALID");
        System.out.println("Test passed: " + operation);
    }

    @Test
    void youtubeValidRequest() throws IDLException {
    	Analyzer analyzer = new Analyzer("oas", "./src/test/resources/youtube_search.yaml", "/search", "get");
    	Map<String, String> validRequest = analyzer.getRandomRequest();
    	assertTrue(analyzer.isValidRequest(validRequest), "The request should be VALID");
    	
    	validRequest = analyzer.getRandomRequest();
    	assertTrue(analyzer.isValidRequest(validRequest), "The request should be VALID");
    	
    	validRequest = analyzer.getRandomRequest();
    	assertTrue(analyzer.isValidRequest(validRequest), "The request should be VALID");
    	
    	validRequest = analyzer.getRandomRequest();
    	assertTrue(analyzer.isValidRequest(validRequest), "The request should be VALID");
    	
    	validRequest = analyzer.getRandomRequest();
    	assertTrue(analyzer.isValidRequest(validRequest), "The request should be VALID");
    	
    	System.out.println("Test passed: youtube_search_valid_request");
    }
    
    @Test
    void youtubeInvalidRequest() throws IDLException {
        Analyzer analyzer = new Analyzer("oas", "./src/test/resources/youtube_search.yaml", "/search", "get");
        Map<String, String> validRequest = analyzer.getInvalidRandomRequest();
        assertFalse(analyzer.isValidRequest(validRequest), "The request should be INVALID");

        validRequest = analyzer.getInvalidRandomRequest();
        assertFalse(analyzer.isValidRequest(validRequest), "The request should be INVALID");

        validRequest = analyzer.getInvalidRandomRequest();
        assertFalse(analyzer.isValidRequest(validRequest), "The request should be INVALID");

        validRequest = analyzer.getInvalidRandomRequest();
        assertFalse(analyzer.isValidRequest(validRequest), "The request should be INVALID");

        validRequest = analyzer.getInvalidRandomRequest();
        assertFalse(analyzer.isValidRequest(validRequest), "The request should be INVALID");

        System.out.println("Test passed: youtube_search_invalid_request");
    }

}
