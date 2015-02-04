/******************************************************************************
 * Copyright (c) 2014,2015 Contributors - see below
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific 
 * ecommon.language governing permissions and limitations under the
 * License.
 *
 * Contributors:
 *    dlwhitehurst 
 *
 *******************************************************************************
 */


package org.citechnical.ecommon.language.utility;

import java.util.StringTokenizer;

/**
 * This class is used to keep a phrase, sentence, paragraph, or any other
 * string of characters split into two pieces, a first and second piece.
 * Think of these pieces as chains used for editing and string handling.
 * Commonly this broken string is composed of words separated by a single
 * space.
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 2/3/15
 *         time: 9:04 AM
 * @version $Id$
 */

public class BrokenString {

    /**
     * First part of this broken string or chain of characters
     */
    protected String firstPart;

    /**
     * Second part of this broken string or chain of characters
     */
    protected String secondPart;

    /**
     * Default constructor
     */
    public BrokenString() {
        // instanced
    }

    /**
     * This method juggles the first and second part strings by
     * taking the last word on the first part and moving it to
     * the second part, thereby shortening the first part and
     * lengthening the second part.
     * @return this object
     */
    public BrokenString reduceFirstPartByOneWord() {

        // Helps with manipulations
        StringBuilder builder = new StringBuilder();

        // Load first piece
        builder.append(getFirstPart());

        // reverse string
        builder.reverse();

        // extract to local string
        String firstPartReverse = builder.toString();

        // pull first word (remember it's backwards)
        StringTokenizer toker = new StringTokenizer(firstPartReverse, " ");

        // refresh builder
        builder = new StringBuilder();

        // reverse this last word from first piece of string, phrase, sentence, or paragraph.
        builder.append(toker.nextToken());
        builder.reverse();

        // extract this word to be removed from first piece
        String removed = builder.toString();

        // add word to a local string for revised second part and set (this)
        String increasedSecondPart = getSecondPart();
        increasedSecondPart = removed + increasedSecondPart;
        setSecondPart(increasedSecondPart);

        // remove word from first part and set (this)
        String reducedFirstPart = getFirstPart();
        int end = reducedFirstPart.length();
        end = end - removed.length();
        reducedFirstPart = reducedFirstPart.substring(0, end);
        setFirstPart(reducedFirstPart);

        // return our adjusted broken pieces
        return this;
    }

    /**
     * Getter for the first part (chain of words, no logic)
     * @return the first part
     */
    public String getFirstPart() {
        return firstPart;
    }

    /**
     * Setter for the first part (chain of words, no logic)
     * @param firstPart - String is broken into two pieces
     *                  (normally just after a word). This is the first part.
     */
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
    }

    /**
     * Getter for the second part (chain of words, no logic)
     * @return the second part
     */
    public String getSecondPart() {
        return secondPart;
    }

    /**
     * Setter for the second part (chain of words, no logic)
     * @param secondPart - String is broken into two pieces
     *                   (normally just after a word). This is the second part.
     */
    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
    }

    /**
     * remove after Unit tests are created.
     * @param args
     */
    public static void main(String[] args) {
        BrokenString obj = new BrokenString();
        obj.setFirstPart("My name is David Whitehurst and I was born in");
        obj.setSecondPart(" Virginia.");

        obj = obj.reduceFirstPartByOneWord();
    }
}
