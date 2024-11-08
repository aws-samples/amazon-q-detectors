// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-rest-easy-deserialization@v1.0 defect=1}
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.springframework.data.util.Pair;


@Path("/")
public class RestEasyDeserializationRuleNonCompliant {

    // Noncompliant: @Consumes annotation set to wildcard "/", potentially allowing unsafe deserialization of any content type.
    @POST
    @Path("/concat")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({ "*/*" })
    public Map<String, String> nonCompliant(Pair pair) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("Result", pair.toString());
        return result;
    }
}
// {/fact}

