/*******************************************************************************
 * Copyright (c) 2012, 2021 IBM Corporation and others.
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
package com.ibm.ws.logging;

import java.util.Queue;

import com.ibm.wsspi.logging.MessageRouter;

/**
 * Liberty Internal Message routing service. Routes messages to sundry logging streams.
 * 
 * MessageRouter is SPI that may be implemented by third-party, so it can't be changed
 * without a major version upgrade, which limits the flexibility of our internal message
 * routing capabilities.
 * 
 * WsMessageRouter is NOT SPI, so it can be tweaked internally as much as we need.
 */
public interface WsMessageRouter extends MessageRouter {

    /**
     * Route the given message.
     * 
     * @param routedMessage Contains the LogRecord and various message formats.
     * @param messageHidden Flag indicating if the message should be hidden or not.
     * 
     * @return true if the message may be logged normally by the caller,
     *         (in addition to whatever logging was performed under this
     *         method), if desired.
     */
    public boolean route(RoutedMessage routedMessage, boolean messageHidden);

    /**
     * TODO
     */
    public void setEarlierMessages(Queue<RoutedMessage> earlierMessages);
}