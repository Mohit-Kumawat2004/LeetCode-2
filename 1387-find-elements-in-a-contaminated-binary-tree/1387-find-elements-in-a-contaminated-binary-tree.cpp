
class FindElements {
    unordered_set<int> recoveredValues;

    void recoverTree(TreeNode* root) {
        if (!root) return;
        recoveredValues.insert(root->val);
        if (root->left) {
            root->left->val = 2 * root->val + 1;
            recoverTree(root->left);
        }
        if (root->right) {
            root->right->val = 2 * root->val + 2;
            recoverTree(root->right);
        }
    }

public:
    FindElements(TreeNode* root) {
        root->val = 0;
        recoverTree(root);
    }

    bool find(int target) {
        return recoveredValues.count(target);
    }
};