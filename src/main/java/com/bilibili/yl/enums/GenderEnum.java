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
 * 用户录入验证  user.gender = GenderEnum.genderOf(genderParameter).value
 */
public enum GenderEnum {
    UNKNOWN(0), MALE(1), FEMALE(2);
    private final int value;

    GenderEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GenderEnum genderOf(int aGenderValue) {
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.value == aGenderValue) {
                return gender;
            }
        }
        return GenderEnum.UNKNOWN;
    }
}
