/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        if (preorder.size == 0) return null
        if (preorder.size == 1) return TreeNode(preorder[0])
        if (preorder.size == 2) return TreeNode(preorder[0]).also {
            it.left = TreeNode(preorder[1])
        }
        if (preorder.size == 3) {
            return TreeNode(preorder[0]).also {
                if (preorder[1] == postorder[0]) {
                    it.left = TreeNode(preorder[1])
                    it.right = TreeNode(preorder[2])
                } else {
                    it.left = TreeNode(preorder[1])
                    it.left.left = TreeNode(preorder[2])
                }
            }
        }

        val root = TreeNode(preorder[0])
        val leftRoot = preorder[1]
        val leftRootIndexInPostOrder = postorder.indexOf(leftRoot)
        
        root.left = constructFromPrePost(
            preorder.subarray(1, 1 + 1 + leftRootIndexInPostOrder),
            postorder.subarray(0, 1 + leftRootIndexInPostOrder)
        )

        if (leftRootIndexInPostOrder != postorder.lastIndex) {
            root.right = constructFromPrePost(
                preorder.subarray(leftRootIndexInPostOrder + 2, preorder.size),
                postorder.subarray(leftRootIndexInPostOrder + 1, postorder.size)
            )
        }

        return root
    }

    private fun IntArray.subarray(start: Int, end: Int): IntArray {
        val res = IntArray(end - start)
        for (i in start until end) { res[i - start] = this[i] }

        return res
    }
}