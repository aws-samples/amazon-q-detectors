// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-lackoffileextensionvalidation@v1.0 defect=0}
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class LackofFileExtensionValidationCompliant {
    // Compliant: Validation applied to file  by checking for specific extension.
    public void compliant(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part filePart = request.getPart("fileToUpload");
            if (filePart.getSubmittedFileName().endsWith(".jpg") || filePart.getSubmittedFileName().endsWith(".png")) {
                InputStream fileInputStream = filePart.getInputStream();
                File fileToSave = new File("WebContent/uploaded-files/" + filePart.getSubmittedFileName());
                Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
                response.getOutputStream().println("<p>File was uploaded.</p>");
            } else {
                response.getOutputStream().println("<p>File was not uploaded.</p>");
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }
}
// {/fact}
