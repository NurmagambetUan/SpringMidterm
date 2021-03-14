package com.example.demo.domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibraryResponse implements Serializable {
    private String responseName;
    private String responseAddress;
}
