package login.controller;

import login.domain.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import login.domain.Account;
import login.service.AccountLoginService;

@RestController
@CrossOrigin(origins = "*")
public class AccountLoginController {

    @Autowired
    private AccountLoginService accountService;

    @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    public String home() {
        return "Welcome to [ Accounts Login Service ] !";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Account login(@RequestBody LoginInfo li){
        return accountService.login(li);
    }

}