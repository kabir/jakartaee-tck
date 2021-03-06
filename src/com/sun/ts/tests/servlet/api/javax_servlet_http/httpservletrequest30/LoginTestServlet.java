/*
 * Copyright (c) 2009, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id:$
 */
package com.sun.ts.tests.servlet.api.javax_servlet_http.httpservletrequest30;

import com.sun.ts.tests.servlet.common.util.ServletTestUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;

public class LoginTestServlet extends HttpServlet {

  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter pw = response.getWriter();
    Boolean passed = true;
    String name = null;
    String passwd = null;

    try {
      request.login(name, passwd);
      passed = false;
      pw.println("Test Failed. ");
      pw.println("Expected ServletException not thrown");
    } catch (ServletException ex) {
      pw.println("Test Passed.");
      pw.println("Expected ServletException thrown: " + ex.getMessage());
    } catch (Exception oex) {
      passed = false;
      pw.println("Test Failed.");
      pw.print("Unexpected Exception thrown: " + oex.getMessage());
    }
    ServletTestUtil.printResult(pw, passed);
  }
}
