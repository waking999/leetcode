package leetcode.success.tree;

public class RBTreeTest {
	private static final int[] a = { 10, 40, 30, 60, 90, 70, 20, 50, 80 };
	private static final boolean mDebugInsert = true;
	private static final boolean mDebugDelete = true;

	public static void main(String[] args) {
		int i, ilen = a.length;
		RBTree<Integer> tree = new RBTree<Integer>();

		System.out.printf("== original data:");
		for (i = 0; i < ilen; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
		for (i = 0; i < ilen; i++) {
			tree.insert(a[i]);
			if (mDebugInsert) {
				System.out.printf("== add: %d\n", a[i]);
				System.out.printf("== tree\n");
				tree.print();
				System.out.println();
			}
		}

		System.out.printf("== 前序遍历: ");
		tree.preOrder();

		System.out.printf("\n== 中序遍历: ");
		tree.inOrder();

		System.out.printf("\n== 后序遍历: ");
		tree.postOrder();
		System.out.printf("\n");

		System.out.printf("== 最小值: %s\n", tree.minimum());
		System.out.printf("== 最大值: %s\n", tree.maximum());
		System.out.printf("== 树的详细信息: \n");
		tree.print();
		System.out.printf("\n");

		// 设置mDebugDelete=true,测试"删除函数"
		if (mDebugDelete) {
			for (i = 0; i < ilen; i++) {
				tree.remove(a[i]);

				System.out.printf("== 删除节点: %d\n", a[i]);
				System.out.printf("== 树的详细信息: \n");
				tree.print();
				System.out.printf("\n");
			}
		}

		// 销毁二叉树
		tree.clear();
	}
}
