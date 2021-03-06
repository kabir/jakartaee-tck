/*
 * Copyright (c) 2007, 2018 Oracle and/or its affiliates. All rights reserved.
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
 * $Id$
 */

package com.sun.ts.tests.ejb30.common.callback;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;

public class InterceptorI extends InterceptorF {
  public InterceptorI() {
    super();
  }

  @Override
  public String getInjectedLocation() {
    return NOT_INJECTED;
  }

  @Override
  protected String getShortName() {
    return "I";
  }

  @Override
  protected void myRemoveInF(InvocationContext inv) throws RuntimeException {
    throw new IllegalStateException("Should not get here.");
  }

  @Override
  protected void myRemoveInE(InvocationContext inv) throws RuntimeException {
    throw new IllegalStateException("Should not get here.");
  }

  @Override
  protected void myRemove(InvocationContext inv) throws RuntimeException {
    throw new IllegalStateException("Should not get here.");
  }

  @Override
  protected void myCreateInF(InvocationContext inv) throws RuntimeException {
    throw new IllegalStateException("Should not get here.");
  }

  @PostConstruct
  @Override
  protected void myCreateInE(InvocationContext inv) throws RuntimeException {
    myCreate0(inv, "I");
  }

  @Override
  @PreDestroy // re-annotated it as another type of lifecycle
  protected void myCreate(InvocationContext inv) throws RuntimeException {
  }

}
