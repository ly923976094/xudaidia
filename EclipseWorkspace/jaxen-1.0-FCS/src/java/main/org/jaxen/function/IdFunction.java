/*
 * $Header: /cvsroot/jaxen/jaxen/src/java/main/org/jaxen/function/IdFunction.java,v 1.3 2002/04/26 17:17:35 jstrachan Exp $
 * $Revision: 1.3 $
 * $Date: 2002/04/26 17:17:35 $
 *
 * ====================================================================
 *
 * Copyright (C) 2000-2002 bob mcwhirter & James Strachan.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions, and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions, and the disclaimer that follows 
 *    these conditions in the documentation and/or other materials 
 *    provided with the distribution.
 *
 * 3. The name "Jaxen" must not be used to endorse or promote products
 *    derived from this software without prior written permission.  For
 *    written permission, please contact license@jaxen.org.
 * 
 * 4. Products derived from this software may not be called "Jaxen", nor
 *    may "Jaxen" appear in their name, without prior written permission
 *    from the Jaxen Project Management (pm@jaxen.org).
 * 
 * In addition, we request (but do not require) that you include in the 
 * end-user documentation provided with the redistribution and/or in the 
 * software itself an acknowledgement equivalent to the following:
 *     "This product includes software developed by the
 *      Jaxen Project (http://www.jaxen.org/)."
 * Alternatively, the acknowledgment may be graphical using the logos 
 * available at http://www.jaxen.org/
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE Jaxen AUTHORS OR THE PROJECT
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * ====================================================================
 * This software consists of voluntary contributions made by many 
 * individuals on behalf of the Jaxen Project and was originally 
 * created by bob mcwhirter <bob@werken.com> and 
 * James Strachan <jstrachan@apache.org>.  For more information on the 
 * Jaxen Project, please see <http://www.jaxen.org/>.
 * 
 * $Id: IdFunction.java,v 1.3 2002/04/26 17:17:35 jstrachan Exp $
 */

package org.jaxen.function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.jaxen.Context;
import org.jaxen.Function;
import org.jaxen.Navigator;
import org.jaxen.FunctionCallException;

/**
 * <p><b>4.1</b> <code><i>node-set</i> id(<i>object</i>)</code> 
 *  
 * @author Erwin Bolwidt (ejb @ klomp.org)
 * @author J\u00e9r\u00f4me N\u00e8gre (jerome.negre @ e-xmlmedia.fr)
 */
public class IdFunction implements Function
{

    public Object call (Context context, List args) throws FunctionCallException
    {
        if ( args.size() == 1 ) {
            return evaluate( context.getNodeSet(),
                             args.get(0), context.getNavigator() );
        }

        throw new FunctionCallException( "id() requires one argument" );
    }

    public static List evaluate (List contextNodes, Object arg, Navigator nav)
    {
        List nodes = new ArrayList();

        if (contextNodes.size() == 0)
            return nodes;
      
        Object contextNode = contextNodes.get(0);

        if (arg instanceof List) {
            Iterator iter = ((List)arg).iterator();
            while (iter.hasNext()) {
                String id = StringFunction.evaluate(iter.next(), nav);
                nodes.addAll( evaluate( contextNodes, id, nav ) );
            }
        } else {
            String ids = StringFunction.evaluate(arg, nav);
            StringTokenizer tok = new StringTokenizer(ids, " \t\n\r");
            while (tok.hasMoreTokens()) {
                String id = tok.nextToken();
                Object node = nav.getElementById(contextNode, id);
                if (node != null) {
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }
}

