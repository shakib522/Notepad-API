package com.example.Notepad.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noteId;
    @NotBlank(message = "Please add type")
    private String type;
    @NotNull
    private boolean textOrCheckBox;
    private String title;
    @NotBlank(message = "note can not be blank")
    private String note;
}
