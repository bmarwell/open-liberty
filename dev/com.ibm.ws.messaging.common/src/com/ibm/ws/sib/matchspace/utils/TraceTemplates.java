/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.sib.matchspace.utils;

// default (English language, United States)
public class TraceTemplates 
       extends java.util.ResourceBundle {
  final String templateValues[][]  = {
   {"com.ibm.ws.sib.matchspace.Matching.<init>.entry","logFileName={0}\nmatchspace={1}\nlogFileType={2}"},
                                     };
  java.util.HashMap templates = new java.util.HashMap();
  
  {
    for (int i=0; i<templateValues.length; i++){
      templates.put(templateValues[i][0],templateValues[i][1]);
    }
  }
  
  public Object handleGetObject(String key) {
    return templates.get(key);
  }

    /* (non-Javadoc)
     * @see java.util.ResourceBundle#getKeys()
     */
    public java.util.Enumeration getKeys()
    {
      // TODO Auto-generated method stub
      // return templates.keySet().iterator();
      return null;
    }
}
