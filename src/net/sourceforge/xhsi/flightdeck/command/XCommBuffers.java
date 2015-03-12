/**
 * XCommBuffers.java
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.sourceforge.xhsi.flightdeck.command;

import java.util.ArrayList;

/**
 * Data to support the xCOMM widget
 */
public class XCommBuffers {

    /**
     * List of active messages
     */
    ArrayList<Display.XCommEntry> messages  = new ArrayList<Display.XCommEntry>();

    /**
     * update
     */
    void update(ArrayList<Display.XCommEntry> newMessages) {
        brk: if (newMessages.size() == messages.size()) {
            for (Display.XCommEntry nm : newMessages) {
                if (!messages.contains(nm)) {
                    break brk;
                }
            }
            return; // All the same so don't change
        }
        messages = newMessages;
    }
}
