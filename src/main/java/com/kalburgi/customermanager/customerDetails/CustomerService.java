package com.kalburgi.customermanager.customerDetails;

import com.kalburgi.customermanager.Exception.UserNotFoundException;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepositry customerRepositry;

    public CustomerService(CustomerRepositry customerRepositry) {
        this.customerRepositry = customerRepositry;
    }

    public Customer addCustomer(Customer customer)  {
        customer.setCustomerCode(UUID.randomUUID().toString());
        customer.setCreatedTime(new Date());
        customer.setEnabled(false);

        String randomCode = RandomString.make(64);
        customer.setVerificationCode(randomCode);
//        sendVerificationCode(customer);
        return customerRepositry.save(customer);
    }

//    private void sendVerificationCode(Customer customer) {
//        String toAddress = customer.getEmail();
//        String fromAddress = "prathameshkalburgi@rediffmail.com";
//        String subject = "Please verify your registration";
//        String senderName = "Bill Yard Team";
//        String content = "Dear [[name]],<br>"
//                + "Please click the link below to verify your registration:<br>"
//                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
//                + "Thank you,<br>"
//                + "Your company name.";
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        helper.setFrom(fromAddress, senderName);
//        helper.setTo(toAddress);
//        helper.setSubject(subject);
//
//        content = content.replace("[[name]]", customer.getName());
//        String verifyURL ="/verify?code=" + customer.getVerificationCode();
//
//        content = content.replace("[[URL]]", verifyURL);
//
//        helper.setText(content, true);
//
//        mailSender.send(message);
//
//    }

    public List<Customer> findAllCustomers() {
        return customerRepositry.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepositry.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepositry.findCustomerById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteCustomer(Long id) {
        customerRepositry.deleteCustomerById(id);
    }
}
