package Service.Process;

import Repositories.EntityDAO.UserDAO;
import Service.Input.InputArea;
import Service.entities.Address;
import Service.entities.User;
import java.sql.Date;

public class Register {
    public static User registerProcess() {
        UserDAO userDAO = new UserDAO();
        User newUser = new User();
        newUser.setRole(StaticRoles.getWriterRole());
        System.out.println("Your welcome\n" +
                "Please enter your information below");
        while (true) {
            System.out.print("please enter username : ");
            String username = InputArea.getUsername();
            if (userDAO.selectByName(username).isPresent()) {
                System.out.println("this is already exist please enter another username");
                continue;
            } else {
                newUser.setUsername(username);
                break;
            }
        }

        System.out.print("please enter national code : ");
        String nationalCode = InputArea.getNationalCode();
        newUser.setNationalCode(nationalCode);
        newUser.setPassword(nationalCode);

        Address address = new Address();
        System.out.println("please enter your Country");
        String country = InputArea.getName();
        address.setCountry(country);
        System.out.println("please enter your City");
        String city = InputArea.getName();
        address.setCity(city);
        System.out.println("please enter your Street");
        String street = InputArea.getText();
        address.setStreet(street);
        System.out.println("please enter your Number");
        String number = InputArea.getName();
        address.setNumber(number);
        newUser.setAddress(address);

        System.out.print("please enter your birthday : ");
        Date birthday = InputArea.getDate();
        newUser.setBirthday(birthday);

        userDAO.add(newUser);
        return newUser;
    }
}
