package pfe.annuaireldap.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest {
    private String id;
    private String uid;
    private String govCNRPS;
    private String govCIN;
    private String cn;
    private String sn;
    private String givenName;
    private String cnLangFr;
    private String cnLangAr;
    private String snLangFr;
    private String snLangAr;
    private String givenNameLangFr;
    private String givenNameLangAr;
    private String mail;
    private String userPassword;
    private String confirmUserPassword;

}
