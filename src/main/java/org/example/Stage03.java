package org.example;

import java.util.List;

public class Stage03 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *
     *
     * 提示：
     *
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     *
     * 提示：
     *
     * 1 <= n <= 8
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

    }


    /**
     * 23. 合并 K 个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     *
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *
     *
     * 提示：
     *
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

    }


    /**
     * 24. 两两交换链表中的节点
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     *
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

    }

    /**
     * 25. K 个一组翻转链表
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     *
     *
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     *
     *
     * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

    }


    /**
     * 26. 删除有序数组中的重复项
     * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     *
     * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
     *
     * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
     * 返回 k 。
     * 判题标准:
     *
     * 系统会用下面的代码来测试你的题解:
     *
     * int[] nums = [...]; // 输入数组
     * int[] expectedNums = [...]; // 长度正确的期望答案
     *
     * int k = removeDuplicates(nums); // 调用
     *
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * 如果所有断言都通过，那么您的题解将被 通过。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按 非严格递增 排列
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

    }


    /**
     * 27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
     *
     * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
     *
     * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
     * 返回 k。
     * 用户评测：
     *
     * 评测机将使用以下代码测试您的解决方案：
     *
     * int[] nums = [...]; // 输入数组
     * int val = ...; // 要移除的值
     * int[] expectedNums = [...]; // 长度正确的预期答案。
     *                             // 它以不等于 val 的值排序。
     *
     * int k = removeElement(nums, val); // 调用你的实现
     *
     * assert k == expectedNums.length;
     * sort(nums, 0, k); // 排序 nums 的前 k 个元素
     * for (int i = 0; i < actualLength; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * 如果所有的断言都通过，你的解决方案将会 通过。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2,_,_]
     * 解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
     * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
     * 示例 2：
     *
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3,_,_,_]
     * 解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
     * 注意这五个元素可以任意顺序返回。
     * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

    }

    /**
     * 28. 找出字符串中第一个匹配项的下标
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     *
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     *
     *
     * 提示：
     *
     * 1 <= haystack.length, needle.length <= 104
     * haystack 和 needle 仅由小写英文字符组成
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

    }


    /**
     * 29. 两数相除
     * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
     *
     * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的 商 。
     *
     * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
     *
     *
     *
     * 示例 1:
     *
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
     * 示例 2:
     *
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
     *
     *
     * 提示：
     *
     * -231 <= dividend, divisor <= 231 - 1
     * divisor != 0
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

    }


    /**
     * 30. 串联所有单词的子串
     * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
     *
     *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
     *
     * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
     * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
     * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
     * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
     * 输出顺序无关紧要。返回 [9,0] 也是可以的。
     * 示例 2：
     *
     * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * 输出：[]
     * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
     * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
     * 所以我们返回一个空数组。
     * 示例 3：
     *
     * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * 输出：[6,9,12]
     * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
     * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
     * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
     * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * words[i] 和 s 由小写英文字母组成
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {

    }
}
