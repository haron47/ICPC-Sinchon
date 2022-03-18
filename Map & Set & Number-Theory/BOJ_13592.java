import java.util.*;

public class BOJ_13592 {
    public static void main(String[] args) {
        JScriptCodeDom.CodeParseException: invalid keyword for function : void , Line 4, Char 22 ---> System.Exception: invalid keyword for function : void
        at JScriptCodeDom.CodeParser.ParseFunctionExpression()
        at JScriptCodeDom.CodeParser.InternalParseStatementCore()
        at JScriptCodeDom.CodeParser.InternalParseStatement()
        at JScriptCodeDom.CodeParser.ParseStatement()
        at JScriptCodeDom.CodeParser.ParseBlock()
        at JScriptCodeDom.CodeParser.ParseClassExpression(CodeClassExpression cls, Boolean allowemptyname)
        at JScriptCodeDom.CodeParser.ParseClassStatement()
        at JScriptCodeDom.CodeParser.InternalParseStatementCore()
        at JScriptCodeDom.CodeParser.InternalParseStatement()
        at JScriptCodeDom.CodeParser.ParseStatement()
        at JScriptCodeDom.CodeParser.ParseBlock()
        at JScriptCodeDom.CodeParser.Parse(String code, String filename, Int32 lineoffset, Boolean keeplinenum)
            --- End of inner exception stack trace ---
            at JScriptCodeDom.CodeParser.Parse(String code, String filename, Int32 lineoffset, Boolean keeplinenum)
        at ProtectorV1.Protect(String[] codes)
        at ProtectorV1.Protect(String code)
        at ASP.javascript_obfuscator_aspx.Button1_Click(Object sender, EventArgs e)
    }
}
