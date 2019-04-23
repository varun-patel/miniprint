/*
 * Point Grey Mini Print Service - authenticated printer utility
 * Copyright (C) 2019  Varun Patel <varun@varunpatel.ca>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.pgmini.miniprint.controller;

import org.pgmini.miniprint.model.Login;
import org.pgmini.miniprint.model.User;
import org.pgmini.miniprint.repositories.CrudRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@ComponentScan(value = "org.pgmini.miniprint")
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());

        return mav;
    }

    @RequestMapping(value = "/LoginProcess", method = RequestMethod.POST)
    public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
        ModelAndView mav = new ModelAndView("login");
        //https://spring.io/guides/gs/accessing-data-mongodb/
        User user = CrudRepository
        if (user != null) {
            mav.setViewName("print");
            mav.addObject("user", user);
        } else{
            mav.addObject("message", "An unknown error occurred");
            mav.addObject("error", request.getRequestedSessionId());
        }

        return mav;
    }

}
