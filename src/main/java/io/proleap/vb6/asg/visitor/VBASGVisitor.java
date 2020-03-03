package io.proleap.vb6.asg.visitor;

import io.proleap.vb6.asg.metamodel.ASGElement;
import io.proleap.vb6.asg.metamodel.api.impl.ApiEnumerationConstantImpl;
import io.proleap.vb6.asg.metamodel.api.impl.ApiEnumerationImpl;
import io.proleap.vb6.asg.metamodel.api.impl.ApiModuleImpl;
import io.proleap.vb6.asg.metamodel.api.impl.ApiProcedureImpl;
import io.proleap.vb6.asg.metamodel.api.impl.ApiPropertyImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ApiEnumerationCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ApiEnumerationConstantCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ApiProcedureCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ApiPropertyCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ArgCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.CallDelegateImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ConstantCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.DictionaryCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ElementVariableCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.EnumerationCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.EnumerationConstantCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.FunctionCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.MeCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.MembersCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ModuleCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.PropertyGetCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.PropertyLetCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.PropertySetCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.ReturnValueCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.SubCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.TypeElementCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.UndefinedCallImpl;
import io.proleap.vb6.asg.metamodel.call.impl.VariableCallImpl;
import io.proleap.vb6.asg.metamodel.impl.ArgImpl;
import io.proleap.vb6.asg.metamodel.impl.AttributeImpl;
import io.proleap.vb6.asg.metamodel.impl.ClazzModuleImpl;
import io.proleap.vb6.asg.metamodel.impl.DefTypeImpl;
import io.proleap.vb6.asg.metamodel.impl.LineLabelImpl;
import io.proleap.vb6.asg.metamodel.impl.LiteralImpl;
import io.proleap.vb6.asg.metamodel.impl.ModuleConfigElementImpl;
import io.proleap.vb6.asg.metamodel.impl.ProcedureDeclarationImpl;
import io.proleap.vb6.asg.metamodel.impl.ProgramImpl;
import io.proleap.vb6.asg.metamodel.impl.StandardModuleImpl;
import io.proleap.vb6.asg.metamodel.impl.TypeElementImpl;
import io.proleap.vb6.asg.metamodel.impl.TypeImpl;
import io.proleap.vb6.asg.metamodel.impl.VariableImpl;
import io.proleap.vb6.asg.metamodel.statement.appactivate.impl.AppActivateImpl;
import io.proleap.vb6.asg.metamodel.statement.beep.impl.BeepImpl;
import io.proleap.vb6.asg.metamodel.statement.chdir.impl.ChDirImpl;
import io.proleap.vb6.asg.metamodel.statement.chdrive.impl.ChDriveImpl;
import io.proleap.vb6.asg.metamodel.statement.close.impl.CloseImpl;
import io.proleap.vb6.asg.metamodel.statement.constant.impl.ConstantImpl;
import io.proleap.vb6.asg.metamodel.statement.date.impl.DateImpl;
import io.proleap.vb6.asg.metamodel.statement.deftype.impl.DeftypeImpl;
import io.proleap.vb6.asg.metamodel.statement.deletesetting.impl.DeleteSettingImpl;
import io.proleap.vb6.asg.metamodel.statement.doloop.impl.DoLoopImpl;
import io.proleap.vb6.asg.metamodel.statement.enumeration.impl.EnumerationConstantImpl;
import io.proleap.vb6.asg.metamodel.statement.enumeration.impl.EnumerationImpl;
import io.proleap.vb6.asg.metamodel.statement.event.impl.EventImpl;
import io.proleap.vb6.asg.metamodel.statement.exit.impl.ExitImpl;
import io.proleap.vb6.asg.metamodel.statement.foreach.impl.ElementVariableImpl;
import io.proleap.vb6.asg.metamodel.statement.foreach.impl.ForEachImpl;
import io.proleap.vb6.asg.metamodel.statement.fornext.impl.ForNextImpl;
import io.proleap.vb6.asg.metamodel.statement.function.impl.FunctionImpl;
import io.proleap.vb6.asg.metamodel.statement.ifstmt.impl.BlockIfThenElseImpl;
import io.proleap.vb6.asg.metamodel.statement.ifstmt.impl.ElseBlockImpl;
import io.proleap.vb6.asg.metamodel.statement.ifstmt.impl.ElseIfBlockImpl;
import io.proleap.vb6.asg.metamodel.statement.ifstmt.impl.IfBlockImpl;
import io.proleap.vb6.asg.metamodel.statement.ifstmt.impl.IfConditionImpl;
import io.proleap.vb6.asg.metamodel.statement.ifstmt.impl.InlineIfThenElseImpl;
import io.proleap.vb6.asg.metamodel.statement.let.impl.LetImpl;
import io.proleap.vb6.asg.metamodel.statement.onerror.impl.OnErrorImpl;
import io.proleap.vb6.asg.metamodel.statement.open.impl.OpenImpl;
import io.proleap.vb6.asg.metamodel.statement.print.impl.PrintImpl;
import io.proleap.vb6.asg.metamodel.statement.property.get.impl.PropertyGetImpl;
import io.proleap.vb6.asg.metamodel.statement.property.let.impl.PropertyLetImpl;
import io.proleap.vb6.asg.metamodel.statement.property.set.impl.PropertySetImpl;
import io.proleap.vb6.asg.metamodel.statement.redim.impl.ReDimImpl;
import io.proleap.vb6.asg.metamodel.statement.resume.impl.ResumeImpl;
import io.proleap.vb6.asg.metamodel.statement.savesetting.impl.SaveSettingImpl;
import io.proleap.vb6.asg.metamodel.statement.select.impl.SelectCaseCondExpressionImpl;
import io.proleap.vb6.asg.metamodel.statement.select.impl.SelectCaseCondImpl;
import io.proleap.vb6.asg.metamodel.statement.select.impl.SelectCaseImpl;
import io.proleap.vb6.asg.metamodel.statement.select.impl.SelectImpl;
import io.proleap.vb6.asg.metamodel.statement.set.impl.SetImpl;
import io.proleap.vb6.asg.metamodel.statement.sub.impl.SubImpl;
import io.proleap.vb6.asg.metamodel.statement.whilestmt.impl.WhileImpl;
import io.proleap.vb6.asg.metamodel.statement.with.impl.WithImpl;
import io.proleap.vb6.asg.metamodel.statement.write.impl.WriteImpl;
import io.proleap.vb6.asg.metamodel.type.VbBaseType;
import io.proleap.vb6.asg.metamodel.type.impl.BaseTypeImpl;
import io.proleap.vb6.asg.metamodel.type.impl.ComplexTypeImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.ArgValueAssignmentImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.ArithmeticValueStmtImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.BooleanValueStmtImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.CallValueStmtImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.LiteralValueStmtImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.NewValueStmtImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.StringValueStmtImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.StructValueStmtImpl;
import io.proleap.vb6.asg.metamodel.valuestmt.impl.ValueAssignmentImpl;

public interface VBASGVisitor {

	void visit(ApiEnumerationCallImpl apiEnumerationCallImpl);

	void visit(ApiEnumerationConstantCallImpl apiEnumerationConstantCallImpl);

	void visit(ApiEnumerationConstantImpl apiEnumerationConstantImpl);

	void visit(ApiEnumerationImpl apiEnumerationImpl);

	void visit(ApiModuleImpl apiModuleImpl);

	void visit(ApiProcedureCallImpl apiProcedureCallImpl);

	void visit(ApiProcedureImpl apiProcedureImpl);

	void visit(ApiPropertyCallImpl apiPropertyCallImpl);

	void visit(ApiPropertyImpl apiPropertyImpl);

	void visit(AppActivateImpl appActivateImpl);

	void visit(ArgCallImpl argCallImpl);

	void visit(ArgImpl argImpl);

	void visit(ArgValueAssignmentImpl argValueAssignmentImpl);

	void visit(ArithmeticValueStmtImpl arithmeticValueStmtImpl);

	void visit(AttributeImpl attributeImpl);

	void visit(BaseTypeImpl baseTypeImpl);

	void visit(BeepImpl beepImpl);

	void visit(BlockIfThenElseImpl blockIfThenElseImpl);

	void visit(BooleanValueStmtImpl booleanValueStmtImpl);

	void visit(CallDelegateImpl callDelegateImpl);

	void visit(CallValueStmtImpl callValueStmtImpl);

	void visit(ChDirImpl chDirImpl);

	void visit(ChDriveImpl chDriveImpl);

	void visit(ClazzModuleImpl clazzModuleImpl);

	void visit(CloseImpl closeImpl);

	void visit(ComplexTypeImpl complexTypeImpl);

	void visit(ConstantCallImpl constantCallImpl);

	void visit(ConstantImpl constantImpl);

	void visit(DateImpl dateImpl);

	void visit(DeftypeImpl deftypeImpl);

	void visit(DefTypeImpl defTypeImpl);

	void visit(DeleteSettingImpl deleteSettingImpl);

	void visit(DictionaryCallImpl dictionaryCallImpl);

	void visit(DoLoopImpl doLoopImpl);

	void visit(ElementVariableCallImpl elementVariableCallImpl);

	void visit(ElementVariableImpl elementVariableImpl);

	void visit(ElseBlockImpl elseBlockImpl);

	void visit(ElseIfBlockImpl elseIfBlockImpl);

	void visit(EnumerationCallImpl enumerationCallImpl);

	void visit(EnumerationConstantCallImpl enumerationConstantCallImpl);

	void visit(EnumerationConstantImpl enumerationConstantImpl);

	void visit(EnumerationImpl enumerationImpl);

	void visit(EventImpl eventImpl);

	void visit(ExitImpl exitImpl);

	void visit(ForEachImpl forEachImpl);

	void visit(ForNextImpl forNextImpl);

	void visit(FunctionCallImpl functionCallImpl);

	void visit(FunctionImpl functionImpl);

	void visit(IfBlockImpl ifBlockImpl);

	void visit(IfConditionImpl ifConditionImpl);

	void visit(InlineIfThenElseImpl inlineIfThenElseImpl);

	void visit(LetImpl letImpl);

	void visit(LineLabelImpl lineLabelImpl);

	void visit(LiteralImpl literalImpl);

	void visit(LiteralValueStmtImpl literalValueStmtImpl);

	void visit(MeCallImpl meCallImpl);

	void visit(MembersCallImpl membersCallImpl);

	void visit(ModuleCallImpl moduleCallImpl);

	void visit(ModuleConfigElementImpl moduleConfigElementImpl);

	void visit(NewValueStmtImpl newValueStmtImpl);

	void visit(OnErrorImpl onErrorImpl);

	void visit(OpenImpl openImpl);

	void visit(PrintImpl printImpl);

	void visit(ProcedureDeclarationImpl procedureDeclarationImpl);

	void visitASGElement(ASGElement element);

	void visit(ProgramImpl programImpl);

	void visit(PropertyGetCallImpl propertyGetCallImpl);

	void visit(PropertyGetImpl propertyGetImpl);

	void visit(PropertyLetCallImpl propertyLetCallImpl);

	void visit(PropertyLetImpl propertyLetImpl);

	void visit(PropertySetCallImpl propertySetCallImpl);

	void visit(PropertySetImpl propertySetImpl);

	void visit(ReDimImpl reDimImpl);

	void visit(ResumeImpl resumeImpl);

	void visit(ReturnValueCallImpl returnValueCallImpl);

	void visit(SaveSettingImpl saveSettingImpl);

	void visit(SelectCaseCondExpressionImpl selectCaseCondExpressionImpl);

	void visit(SelectCaseCondImpl selectCaseCondImpl);

	void visit(SelectCaseImpl selectCaseImpl);

	void visit(SelectImpl selectImpl);

	void visit(SetImpl setImpl);

	void visit(StandardModuleImpl standardModuleImpl);

	void visit(StringValueStmtImpl stringValueStmtImpl);

	void visit(StructValueStmtImpl structValueStmtImpl);

	void visit(SubCallImpl subCallImpl);

	void visit(SubImpl subImpl);

	void visit(TypeElementCallImpl typeElementCallImpl);

	void visit(TypeElementImpl typeElementImpl);

	void visit(TypeImpl typeImpl);

	void visit(UndefinedCallImpl undefinedCallImpl);

	void visit(ValueAssignmentImpl valueAssignmentImpl);

	void visit(VariableCallImpl variableCallImpl);

	void visit(VariableImpl variableImpl);

	void visit(VbBaseType vbBaseType);

	void visit(WhileImpl whileImpl);

	void visit(WithImpl withImpl);

	void visit(WriteImpl writeImpl);

}