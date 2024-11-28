// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-lackoffileextensionvalidation@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class LackofFileExtensionValidationNonCompliant {
    // NonCompliant: No Validation applied for uploaded file.
    public void nonCompliant(HttpServletRequest request , HttpServletResponse response) {
        try {
            Part filePart = request.getPart("fileToUpload");
            InputStream fileInputStream = filePart.getInputStream();
            File fileToSave = new File("WebContent/uploaded-files/" + filePart.getSubmittedFileName());
            Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
            response.getOutputStream().println("<p>File was uploaded.</p>");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
// {/fact}
