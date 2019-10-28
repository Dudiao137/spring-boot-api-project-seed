package win.ots.hello.web.vo;

import lombok.Data;
import win.ots.hello.core.valid.Mobile;

import javax.validation.constraints.*;


/**
 * @author : sy.wang
 * @date : 2019-10-24
 */
@Data
public class TestVo {

    private String id;

    @NotBlank
    @Size(max = 20, min = 2)
    private String name;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z][0-9]")
    private String password;

    @Max(10)
    @Min(1)
    private Integer level;

    @Email
    private String email;

    @Mobile
    private String mobile;
}
