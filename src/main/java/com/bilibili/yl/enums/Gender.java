package com.bilibili.yl.enums;

/**
 * 性别枚举类
 * <p>
 * UNKNOWN为保密
 * <p>
 * MALE为保密
 * <p>
 * FEMALE为保密
 * <p>
 * 用户录入验证  user.gender = Gender.genderOf(genderParameter).value
 */
public enum Gender {
    UNKNOWN(0), MALE(1), FEMALE(2);
    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Gender genderOf(int aGenderValue) {
        for (Gender gender : Gender.values()) {
            if (gender.value == aGenderValue) {
                return gender;
            }
        }
        return Gender.UNKNOWN;
    }
}
