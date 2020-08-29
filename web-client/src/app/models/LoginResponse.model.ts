export interface LoginResponse {
    token: string;
    refreshToken: string;
    profileId: number;
    isProfileCompleted: boolean;
}