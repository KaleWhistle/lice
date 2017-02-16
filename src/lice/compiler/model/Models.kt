/**
 * Created by ice1000 on 2017/2/16.
 *
 * @author ice1000
 */
package lice.compiler.model

interface StringNode {
	val strRepr: String
}

class StringMiddleNode(val list: MutableList<StringNode> = mutableListOf<StringNode>()) : StringNode {
	val empty: Boolean
		get() = list.isEmpty()

	override val strRepr: String
		get() = list.fold(StringBuffer("[")) { stringBuffer, last ->
			stringBuffer.append(" ").append(last.strRepr)
		}.append(" ]").toString()

	fun add(n: StringNode) = list.add(n)
}

class StringLeafNode(val str: String) : StringNode {
	override val strRepr = str
}

object EmptyStringNode : StringNode {
	override val strRepr = ""
}
