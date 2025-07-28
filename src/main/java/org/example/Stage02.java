package com.company.throb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author z20712
 * @since 4.0.0
 */
public class Stage02 {
    /**
     * 11. 盛最多水的容器
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * <p>
     * 输入：height = [1,1]
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == height.length
     * 2 <= n <= 105
     * 0 <= height[i] <= 104
     */
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;
    }


    /**
     * 12. 整数转罗马数字
     * 七个不同的符号代表罗马数字，其值如下：
     * <p>
     * 符号	值
     * I	1
     * V	5
     * X	10
     * L	50
     * C	100
     * D	500
     * M	1000
     * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
     * <p>
     * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
     * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
     * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
     * 给定一个整数，将其转换为罗马数字。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = 3749
     * <p>
     * 输出： "MMMDCCXLIX"
     * <p>
     * 解释：
     * <p>
     * 3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
     * 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
     * 40 = XL 由于 50 (L) 减 10 (X)
     * 9 = IX 由于 10 (X) 减 1 (I)
     * 注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
     * 示例 2：
     * <p>
     * 输入：num = 58
     * <p>
     * 输出："LVIII"
     * <p>
     * 解释：
     * <p>
     * 50 = L
     * 8 = VIII
     * 示例 3：
     * <p>
     * 输入：num = 1994
     * <p>
     * 输出："MCMXCIV"
     * <p>
     * 解释：
     * <p>
     * 1000 = M
     * 900 = CM
     * 90 = XC
     * 4 = IV
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= num <= 3999
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String numStr = String.valueOf(num);
        for (int i = numStr.length(); i > 0; i--) {
            int subNum = Integer.parseInt(numStr.substring(numStr.length() - i, numStr.length() - i + 1));
            switch (i) {
                case 4:
                    for (int j = 0; j < subNum; j++) {
                        sb.append("M");
                    }
                    break;
                case 3:
                    if (subNum == 4) {
                        sb.append("CD");
                    } else if (subNum == 9) {
                        sb.append("CM");
                    } else if (subNum < 4) {
                        for (int j = 0; j < subNum; j++) {
                            sb.append("C");
                        }
                    } else {
                        sb.append("D");
                        for (int j = 0; j < subNum - 5; j++) {
                            sb.append("C");
                        }
                    }
                    break;
                case 2:
                    if (subNum == 4) {
                        sb.append("XL");
                    } else if (subNum == 9) {
                        sb.append("XC");
                    } else if (subNum < 4) {
                        for (int j = 0; j < subNum; j++) {
                            sb.append("X");
                        }
                    } else {
                        sb.append("L");
                        for (int j = 0; j < subNum - 5; j++) {
                            sb.append("X");
                        }
                    }
                    break;
                case 1:
                    if (subNum == 4) {
                        sb.append("IV");
                    } else if (subNum == 9) {
                        sb.append("IX");
                    } else if (subNum < 4) {
                        for (int j = 0; j < subNum; j++) {
                            sb.append("I");
                        }
                    } else {
                        sb.append("V");
                        for (int j = 0; j < subNum - 5; j++) {
                            sb.append("I");
                        }
                    }
                    break;
            }
        }
        return sb.toString();
    }


    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "III"
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: s = "IV"
     * 输出: 4
     * 示例 3:
     * <p>
     * 输入: s = "IX"
     * 输出: 9
     * 示例 4:
     * <p>
     * 输入: s = "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: s = "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 15
     * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - 百度百科。
     */
    public int romanToInt(String s) {
        Map<Character, Integer> baseMap = new HashMap<>();
        baseMap.put('I', 1);
        baseMap.put('V', 5);
        baseMap.put('X', 10);
        baseMap.put('L', 50);
        baseMap.put('C', 100);
        baseMap.put('D', 500);
        baseMap.put('M', 1000);
        int count = 0;
        for (int i = 0; i < s.length(); ) {
            int curVal = baseMap.get(s.charAt(i));
            if (i == s.length() - 1) {
                count += curVal;
                return count;
            }
            int nextVal = baseMap.get(s.charAt(i + 1));

            if (curVal < nextVal) {
                count += nextVal - curVal;
                i += 2;
            } else {
                count += curVal;
                i += 1;
            }
        }
        return count;
    }


    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 如果非空，则仅由小写英文字母组成
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean flag = true;
            for (String str : strs) {
                if (str.length() <= i) {
                    flag = false;
                    break;
                }
                boolean check = str.charAt(i) == c;
                flag &= check;
            }
            if (flag) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }


    /**
     * 15. 三数之和
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     * <p>
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ) {
            if (nums[i] > 0) break;
            int target = -nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < target) {
                    do j++;
                    while (j < k && nums[j] == nums[j - 1]);
                } else {
                    do k--;
                    while (j < k && nums[k] == nums[k + 1]);
                }
            }
            do i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]);
        }
        return res;
    }


    /**
     * 16. 最接近的三数之和
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * <p>
     * 返回这三个数的和。
     * <p>
     * 假定每组输入只存在恰好一个解。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     * 解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; ) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);
                if (diff < Math.abs(target - res)) {
                    res = nums[i] + nums[j] + nums[k];
                    if (diff == 0) {
                        return res;
                    }
                }
                if (sum > target) {
                    do k--;
                    while (j < k && nums[k] == nums[k + 1]);
                } else {
                    do j++;
                    while (j < k && nums[j] == nums[j - 1]);
                }
            }
            do i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]);
        }
        return res;
    }

    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * | abc | def
     * ghi   | jkl | mno
     * prqs  | tuv | wxyz
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * <p>
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            String str = map.get(Integer.parseInt(digits.charAt(i) + ""));
            List<String> temp = new ArrayList<>(res);
            res.clear();
            for (int j = 0; j < str.length(); j++) {
                if (temp.isEmpty()) {
                    res.add(String.valueOf(str.charAt(j)));
                } else {
                    for (String t : temp) {
                        res.add(t + str.charAt(j));
                    }
                }
            }
        }
        return res;
    }


    /**
     * 18. 四数之和
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     * <p>
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            while (i > 0 && i < nums.length - 3 && nums[i - 1] == nums[i]) i++;
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j > i + 1 && j < nums.length - 2 && nums[j - 1] == nums[j]) j++;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        res.add(list);
                        while (left + 1 < right && nums[left + 1] == nums[left]) left++;
                        while (left < right - 1 && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        do right--;
                        while (left < right - 1 && nums[right] == nums[right - 1]);
                    } else {
                        do left++;
                        while (left + 1 < right && nums[left + 1] == nums[left]);
                    }
                }
            }
        }
        return res;
    }


    public static class ListNode {
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
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * <p>
     * <p>
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "()"
     * <p>
     * 输出：true
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "()[]{}"
     * <p>
     * 输出：true
     * <p>
     * 示例 3：
     * <p>
     * 输入：s = "(]"
     * <p>
     * 输出：false
     * <p>
     * 示例 4：
     * <p>
     * 输入：s = "([])"
     * <p>
     * 输出：true
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     */
    public boolean isValid(String s) {
        return false;
    }
}
