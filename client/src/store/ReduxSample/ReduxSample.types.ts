export interface UserSampleState {
  id: number;
  email: string;
  firstName: string;
  lastName: string;
  avatar: string;
}

export interface ReduxSampleState {
  sampleUsers: UserSampleState[];
  sampleButton: {
    message: string;
    isClicked: boolean;
    loading: boolean;
  };
}
