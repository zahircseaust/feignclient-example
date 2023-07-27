package net.codejava.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class UserDto {

    private UserName userName;
    private double salary;
}
