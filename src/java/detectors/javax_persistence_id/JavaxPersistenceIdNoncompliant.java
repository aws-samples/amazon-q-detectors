// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-javax-persistence-id-annotation-attached-to-32bit@v1.0 defects=1}
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JavaxPersistenceIdNoncompliant {

    // Noncompliant: @Id annotation used with @GeneratedValue on a 32-bit Integer field.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_sla_id", nullable = false)
    private Integer id;

    @Column(name = "type_id", nullable = false)
    private Integer typeId;

    @Column(name = "type", nullable = false, length = 255)
    private String type;
}
// {/fact}
