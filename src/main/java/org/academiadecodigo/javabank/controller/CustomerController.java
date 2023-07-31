package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.dto.CustomerDto;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Controller responsible for rendering {@link Customer} related views
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Renders a view with a list of customers
     *
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listCustomers(CustomerDto customerDto) {
        customerDto.addAttribute("customers", customerService.list());
        return "customer/list";
    }

    /**
     * Renders a view with customer details
     *
     * @param id the customer id
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showCustomer(@PathVariable Integer id, CustomerDto customerDto) {
        model.addAttribute("customer", customerService.get(id));
        model.addAttribute("recipients", customerService.listRecipients(id));
        return "customer/show";
    }

    /**
     * Deletes a customer
     *
     * @param id the customer id
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = "{id}/delete")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }

    /**
     * Deletes a recipient from a customer
     *
     * @param cid the customer id
     * @param rid the recipient id
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/recipient/{rid}/delete/")
    public String deleteRecipient(@PathVariable Integer cid, @PathVariable Integer rid) {
        customerService.removeRecipient(cid, rid);
        return "redirect:/customer/" + cid;
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public String edit(@PathVariable Integer id) {
        customerService.

    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String saveCustomer(@Valid @ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "customer/add";
        }
        Customer savedCustomer = customerService.save(customer);
        redirectAttributes.addFlashAttribute("lastAction", "Added customer successfully!");
        return "redirect:/customer/list";
    }
}

