/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.watchlist.internal.api;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.xwiki.component.annotation.Role;

import com.xpn.xwiki.XWikiException;

/**
 * Component that sends notifications to users.
 *
 * @version $Id$
 */
@Role
public interface WatchListNotifier
{
    /**
     * Sends out a notification to the subscriber that certain events occurred.
     *
     * @param subscriber user to notify
     * @param events list of events
     * @param templateDocument the document which contains the template to use for the message that is being sent
     * @param previousFireTime last time the notification was fired
     * @throws XWikiException if mail sending fails
     * @deprecated since 7.1M1
     */
    @Deprecated
    void sendNotification(String subscriber, List<WatchListEvent> events, String templateDocument,
        Date previousFireTime) throws XWikiException;

    /**
     * @param subscribers the list of users to notify
     * @param events the list of events that occurred in a certain amount of time and of which the subscribers *might*
     *            be interested. The actual events each subscriber is interested in and that he will be notified of will
     *            be computed in the background
     * @param notificationData a map of additional data about this notification (e.g. "previousFireTime", etc.)
     * @throws WatchListException if problems occur
     */
    void sendNotification(Collection<String> subscribers, List<WatchListEvent> events,
        Map<String, Object> notificationData) throws WatchListException;
}
