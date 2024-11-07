// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-rest-easy-deserialization@v1.0 defect=0}
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/")
public class RestEasyDeserializationRuleCompliant {

    // Compliant: `@Consumes` annotation set to specific `MediaType.APPLICATION_JSON`, ensuring safe deserialization of JSON content only.
    @POST
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, Integer> compliant(ArrayList<Object> elements) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        result.put("Result", elements.size());
        return result;
    }
}
// {/fact}

