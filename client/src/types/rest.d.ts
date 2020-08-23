/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.25.695 on 2020-08-23 22:56:22.

export interface CommonResponse {
    code: number;
    message: string;
}

export interface AddDailyMealsRequest {
    photoPath: string;
    mealType: MealType;
    foods: AddFoodRequest[];
}

export interface AddFoodRequest {
    foodSequence: number;
    foodName: string;
    calorie: number;
    carbs: string;
    protein: string;
    fat: string;
    amount: string;
    amountUnit: string;
}

export interface DailyMealResponse {
    diarySequence: number;
    diaryDay: string;
    lastUpdateDate: string;
    totalCalories: number;
    mealDiaries: MealDiaryResponse[];
}

export interface EditDailyMealsRequest {
    mealDiarySequence: number;
    photoPath: string;
    mealType: MealType;
    foods: EditFoodRequest[];
}

export interface EditFoodRequest {
    foodSequence: number;
    foodName: string;
    calorie: number;
    carbs: string;
    protein: string;
    fat: string;
    amount: string;
    amountUnit: string;
}

export interface FoodResponse {
    foodSequence: number;
    foodName: string;
    calorie: number;
    carbs: string;
    protein: string;
    fat: string;
    amount: string;
    amountUnit: string;
}

export interface GoveFoodResponse {
    name: string;
    calorie: string;
    carbs: string;
    protein: string;
    fat: string;
    servingSize: string;
}

export interface GoveFoodsResponse {
    totalCount: number;
    foods: GoveFoodResponse[];
}

export interface MealDiaryResponse {
    mealDiarySequence: number;
    mealType: string;
    mealCalories: number;
    mealPhotoPath: string;
    foods: FoodResponse[];
}

export interface UserDto {
    userSequence: number;
    sex: UserSexType;
    height: number;
    heightUnit: UnitType;
    weight: number;
    weightUnit: UnitType;
    birth: Date;
    nickname: string;
    loginType: UserLoginType;
    refreshToken: string;
    uniqueId: string;
    targetWeight: number;
    profileImage: string;
}

export type GoalStateType = "TO_DO" | "IN_PROGRESS" | "SUCCESS" | "FAIL" | "PAUSED";

export type MealType = "BREAKFAST" | "LUNCH" | "DINNER" | "SNACK";

export type UnitType = "KG" | "CM";

export type UserLoginType = "KAKAOTALK" | "FACEBOOK" | "EMAIL";

export type UserSexType = "MALE" | "FEMALE";
