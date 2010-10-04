/*
 * SIP Communicator, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package net.java.sip.communicator.service.protocol.event;

import java.util.*;

import net.java.sip.communicator.service.protocol.*;

/**
 * Events of this class represent the fact that a server stored
 * subscription/contact has been moved from one server stored group to another.
 * Such events are only generated by implementations of
 * OperationSetPersistentPresence as non persistent presence operation sets do
 * not support the notion of server stored groups.
 *
 * @author Emil Ivov
 */
public class SubscriptionMovedEvent
    extends EventObject
{
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 0L;

    private ContactGroup oldParent = null;
    private ContactGroup newParent = null;
    private ProtocolProviderService sourceProvider = null;

    /**
     * Creates an event instance with the specified source contact and old and
     * new parent.
     *
     * @param sourceContact the <tt>Contact</tt> that has been moved.
     * @param sourceProvider a reference to the <tt>ProtocolProviderService</tt>
     * that the source <tt>Contact</tt> belongs to.
     * @param oldParent the <tt>ContactGroup</tt> that has previously been
     * the parent
     * @param newParent the new <tt>ContactGroup</tt> parent of
     * <tt>sourceContact</tt>
     */
    public SubscriptionMovedEvent(Contact sourceContact,
                                  ProtocolProviderService sourceProvider,
                                  ContactGroup oldParent,
                                  ContactGroup newParent)
    {
        super(sourceContact);
        this.oldParent = oldParent;
        this.newParent = newParent;
        this.sourceProvider = sourceProvider;
    }

    /**
     * Returns a reference to the contact that has been moved.
     * @return a reference to the <tt>Contact</tt> that has been moved.
     */
    public Contact getSourceContact()
    {
        return (Contact)getSource();
    }

    /**
     * Returns a reference to the ContactGroup that contained the source contact
     * before it was moved.
     * @return a reference to the previous <tt>ContactGroup</tt> parent of
     * the source <tt>Contact</tt>.
     */
    public ContactGroup getOldParentGroup()
    {
        return oldParent;
    }

    /**
     * Returns a reference to the ContactGroup that currently contains the
     * source contact.
     *
     * @return a reference to the current <tt>ContactGroup</tt> parent of
     * the source <tt>Contact</tt>.
     */
    public ContactGroup getNewParentGroup()
    {
        return newParent;
    }

    /**
     * Returns the provider that the source contact belongs to.
     * @return the provider that the source contact belongs to.
     */
    public ProtocolProviderService getSourceProvider()
    {
        return sourceProvider;
    }


    /**
     * Returns a String representation of this ContactPresenceStatusChangeEvent
     *
     * @return A a String representation of this
     * SubscriptionMovedEvent.
     */
    public String toString()
    {
        StringBuffer buff
            = new StringBuffer("SubscriptionMovedEvent-[ ContactID=");
        buff.append(getSourceContact().getAddress());
        buff.append(", OldParentGroup=").append(getOldParentGroup().getGroupName());
        buff.append(", NewParentGroup=").append(getNewParentGroup().getGroupName());
        return buff.toString();
    }

}
