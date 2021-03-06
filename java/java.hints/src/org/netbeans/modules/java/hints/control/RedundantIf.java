/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.java.hints.control;

import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.Fix;
import org.netbeans.spi.java.hints.ErrorDescriptionFactory;
import org.netbeans.spi.java.hints.Hint;
import org.netbeans.spi.java.hints.HintContext;
import org.netbeans.spi.java.hints.JavaFixUtilities;
import org.netbeans.spi.java.hints.TriggerPattern;
import org.netbeans.spi.java.hints.TriggerPatterns;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author lahvac
 */
@Messages({
    "DN_redundantIf=Redundant if statement",
    "DESC_redundantIf=Redundant if statement",
    "ERR_redundantIf=The if statement is redundant",
    "FIX_redundantIf=Remove the if statement",
})
@Hint(displayName="#DN_redundantIf", description="#DESC_redundantIf", category="general")
public class RedundantIf {
    
    @TriggerPatterns({
        @TriggerPattern("if ($cond) return true; else return false;"),
        @TriggerPattern("if ($cond) return true; return false;")
    })
    public static ErrorDescription redundantIfPos(HintContext ctx) {
        Fix f = JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_redundantIf(), ctx.getPath(), "return $cond;");
        
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_redundantIf(), f);
    }
    
    @TriggerPatterns({
        @TriggerPattern("if ($cond) return false; else return true;"),
        @TriggerPattern("if ($cond) return false; return true;")
    })
    public static ErrorDescription redundantIfNeg(HintContext ctx) {
        Fix f = JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_redundantIf(), ctx.getPath(), "return !$cond;");
        
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_redundantIf(), f);
    }
    
    @TriggerPattern("if ($cond) $var = true; else $var = false;")
    public static ErrorDescription redundantIfVar(HintContext ctx) {
        Fix f = JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_redundantIf(), ctx.getPath(), "$var = $cond;");
        
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_redundantIf(), f);
    }
    
    @TriggerPattern("if ($cond) $var = false; else $var = true;")
    public static ErrorDescription redundantIfVarNeg(HintContext ctx) {
        Fix f = JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_redundantIf(), ctx.getPath(), "$var = !$cond;");
        
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_redundantIf(), f);
    }
}
