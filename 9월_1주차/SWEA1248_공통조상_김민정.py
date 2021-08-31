class Tree: # 트리 클래스
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def find_LCA(root, p, q):  # 최소 공통 조상 찾기
    if root in (p, q, None):
        print("stop")
        return root

    left = find_LCA(root.left, p, q)
    right = find_LCA(root.right, p, q)
    return root if (left and right) else (left or right)


def count_children(root):
    if root:
        left = count_children(root.left)
        right = count_children(root.right)
        return 1 + left + right
    return 0


T = int(input())
for t in range(1, T + 1):
    V, E, t1, t2 = map(int, input().split())
    trees = [Tree(x) for x in range(V + 1)]
    edges = list(map(int, input().split()))

    for i in range(E):
        parent, child = trees[edges[i * 2]], trees[edges[i * 2 + 1]]

        if not parent.left:  # 왼쪽 노드가 없으면
            parent.left = child
        else:
            parent.right = child

    lca = find_LCA(trees[1], trees[t1], trees[t2])  # root node에서 t1, t2까지 탐색
    cnt = count_children(lca)
    print('#{} {} {}'.format(t, lca.val, cnt))