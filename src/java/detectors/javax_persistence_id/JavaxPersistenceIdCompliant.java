// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-javax-persistence-id-annotation-attached-to-32bit@v1.0 defects=0}
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role_sla_type")
public class JavaxPersistenceIdCompliant {

    // Compliant: `@Id annotation used on a Long field, avoiding potential overflow issues associated with 32-bit integer IDs.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_sla_id", nullable = false)
    private Long id;

    @Column(name = "type_id", nullable = false)
    private Integer typeId;

    @Column(name = "type", nullable = false, length = 255)
    private String type;
}
// {/fact}
