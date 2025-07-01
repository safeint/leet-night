package org.example;

import org.example.extensions.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Stage01 {
    /**
     * 01
     * 两数之和
     * <p>
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     * <p>
     * <p>
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗
     *
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int subtract = target - nums[i];
            if (idxMap.containsKey(subtract)) {
                return new int[]{idxMap.get(subtract), i};
            } else {
                idxMap.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 02
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * <p>
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + flag;
            flag = sum / 10;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }

    /**
     * 03
     * 无重复字符的最长子串
     * <p>
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    public int lengthOfLongestSubstring(String s) {
        char[] charArr = s.toCharArray();
        int[] asciiCode;
        int maxLen = 0;
        for (int i = 0; i < charArr.length; i++) {
            asciiCode = new int[128];
            asciiCode[charArr[i]] = 1;
            for (int j = i + 1; j < charArr.length; j++) {
                if (asciiCode[charArr[j]] == 0) {
                    asciiCode[charArr[j]] = 1;
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return Math.max(1, maxLen);
    }

    /**
     * 04
     * 寻找两个正序数组的中位数
     * <p>
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int historyVal = 0;
        boolean isEven = (m + n) % 2 == 0;
        int c1 = 0, c2 = 0;
        if (m == 0) {
            return isEven ? (double) (nums2[n / 2 - 1] + nums2[n / 2]) / 2 : (double) nums2[n / 2];
        }
        if (n == 0) {
            return isEven ? (double) (nums1[m / 2 - 1] + nums1[m / 2]) / 2 : (double) nums1[m / 2];
        }
        for (int i = 0; i < (m + n) / 2; i++) {
            if (c1 < m && c2 < n) {
                if (nums1[c1] < nums2[c2]) {
                    historyVal = nums1[c1++];
                } else {
                    historyVal = nums2[c2++];
                }
            } else if (c1 < m) {
                historyVal = nums1[c1++];
            } else {
                historyVal = nums2[c2++];
            }
        }
        if (isEven) {
            if (nums1[Math.min(c1, m - 1)] > historyVal && nums2[Math.min(c2, n - 1)] > historyVal) {
                return (double) (historyVal + Math.min(nums1[Math.min(c1, m - 1)], nums2[Math.min(c2, n - 1)])) / 2;
            } else if (nums1[Math.min(c1, m - 1)] < historyVal) {
                return (double) (historyVal + nums2[c2]) / 2;
            } else {
                return (double) (historyVal + nums1[c1]) / 2;
            }
        } else {
            if (nums1[Math.min(c1, m - 1)] > historyVal && nums2[Math.min(c2, n - 1)] > historyVal) {
                return Math.min(nums1[Math.min(c1, m - 1)], nums2[Math.min(c2, n - 1)]);
            } else if (nums1[Math.min(c1, m - 1)] < historyVal) {
                return nums2[c2];
            } else {
                return nums1[c1];
            }
        }
    }

    /**
     * 05
     * 最长回文子串
     * <p>
     * 给你一个字符串 s，找到 s 中最长的 回文 子串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0, end = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int s1 = left + 1;
            int e1 = right - 1;
            int len1 = e1 - s1 + 1;

            // even
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len2 = (right - 1) - (left + 1) + 1;

            if (len1 > maxLen || len2 > maxLen) {
                if (len1 > len2) {
                    start = s1;
                    end = e1;
                    maxLen = len1;
                } else {
                    start = left + 1;
                    end = right - 1;
                    maxLen = len2;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 06
     * Z 字形变换
     * <p>
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     * <p>
     * 输入：s = "A", numRows = 1
     * 输出："A"
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(s.charAt(i));
            for (int idx = i; idx < s.length(); ) {
                idx = idx + (numRows - i - 1) + (numRows - i - 1);
                if ((numRows - i - 1 != 0) && idx < s.length()) {
                    sb.append(s.charAt(idx));
                }
                if (i != 0) {
                    idx = idx + i + i;
                    if (idx < s.length()) {
                        sb.append(s.charAt(idx));
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 07
     * 整数反转
     * <p>
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * <p>
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * <p>
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     * <p>
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     * <p>
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     * <p>
     * 输入：x = 0
     * 输出：0
     * <p>
     * <p>
     * 提示：
     * <p>
     * -231 <= x <= 231 - 1
     */
    public int reverse(int x) {
        boolean flag = x > 0;
        String str = String.valueOf(Math.abs(x));
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        try {
            int res = Integer.parseInt(builder.toString());
            return flag ? res : -res;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 08
     * 字符串转换整数 (atoi)
     * <p>
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
     * <p>
     * 函数 myAtoi(string s) 的算法如下：
     * <p>
     * 空格：读入字符串并丢弃无用的前导空格（" "）
     * 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
     * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
     * 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
     * 返回整数作为最终结果。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "42"
     * <p>
     * 输出：42
     * <p>
     * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     * <p>
     * 带下划线线的字符是所读的内容，插入符号是当前读入位置。
     * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
     * ^
     * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * ^
     * 第 3 步："42"（读入 "42"）
     * ^
     * 示例 2：
     * <p>
     * 输入：s = " -042"
     * <p>
     * 输出：-42
     * <p>
     * 解释：
     * <p>
     * 第 1 步："   -042"（读入前导空格，但忽视掉）
     * ^
     * 第 2 步："   -042"（读入 '-' 字符，所以结果应该是负数）
     * ^
     * 第 3 步："   -042"（读入 "042"，在结果中忽略前导零）
     * ^
     * 示例 3：
     * <p>
     * 输入：s = "1337c0d3"
     * <p>
     * 输出：1337
     * <p>
     * 解释：
     * <p>
     * 第 1 步："1337c0d3"（当前没有读入字符，因为没有前导空格）
     * ^
     * 第 2 步："1337c0d3"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * ^
     * 第 3 步："1337c0d3"（读入 "1337"；由于下一个字符不是一个数字，所以读入停止）
     * ^
     * 示例 4：
     * <p>
     * 输入：s = "0-1"
     * <p>
     * 输出：0
     * <p>
     * 解释：
     * <p>
     * 第 1 步："0-1" (当前没有读入字符，因为没有前导空格)
     * ^
     * 第 2 步："0-1" (当前没有读入字符，因为这里不存在 '-' 或者 '+')
     * ^
     * 第 3 步："0-1" (读入 "0"；由于下一个字符不是一个数字，所以读入停止)
     * ^
     * 示例 5：
     * <p>
     * 输入：s = "words and 987"
     * <p>
     * 输出：0
     * <p>
     * 解释：
     * <p>
     * 读取在第一个非数字字符“w”处停止。
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 200
     * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
     */
    public int myAtoi(String s) {
        boolean trimFlag = true;
        boolean signFlag = true;
        boolean positiveFlag = true;
        boolean zeroStartFlag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (trimFlag) {
                    continue;
                } else {
                    break;
                }
            } else if (c == '+' || c == '-') {
                if (signFlag) {
                    sb.append(c);
                    positiveFlag = c == '+';
                    trimFlag = false;
                    signFlag = false;
                } else {
                    break;
                }
            } else if (c == '0') {
                if (zeroStartFlag) {
                    if (sb.length() == 0) {
                        sb.append(c);
                    } else if (sb.length() == 1) {
                        char first = sb.charAt(0);
                        if (first == '-' || first == '+') {
                            sb.append(c);
                        } else if (first == '0') {
                        } else {
                            sb.append(0);
                        }
                    } else if (sb.length() == 2) {
                        char first = sb.charAt(0);
                        char second = sb.charAt(1);
                        if (first == '-' || first == '+') {
                            if (second == '0') {
                            } else {
                                sb.append(0);
                                zeroStartFlag = false;
                            }
                        } else {
                            sb.append(0);
                            zeroStartFlag = false;
                        }
                    }
                } else {
                    sb.append(c);
                }
                trimFlag = false;
                signFlag = false;
            } else if (c > '0' && c <= '9') {
                if (sb.length() == 0) {
                    sb.append(c);
                } else if (sb.length() == 1) {
                    char first = sb.charAt(0);
                    if (first == '+' || first == '-') {
                        sb.append(c);
                    } else if (sb.charAt(0) == '0') {
                        sb.deleteCharAt(0);
                        sb.append(c);
                    }
                }
                trimFlag = false;
                signFlag = false;
                zeroStartFlag = false;
            } else {
                break;
            }
        }
        if (sb.length() > 0) {
            try {
                return Integer.parseInt(sb.toString());
            } catch (Exception e) {
                if (positiveFlag) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        } else {
            return 0;
        }
    }

    /**
     * 09
     * 回文数
     * <p>
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 例如，121 是回文，而 123 不是。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * <p>
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * -231 <= x <= 231 - 1
     * <p>
     * <p>
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int half = 0;
        while (x > half) {
            half = half * 10 + x % 10;
            x /= 10;
        }

        return x == half || x == half / 10;
    }

    /**
     * 10
     * 正则表达式匹配
     * <p>
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * <p>
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * 1 <= p.length <= 20
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char prev = p.charAt(j - 2);
                    if (prev != '.' && prev != sc) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
