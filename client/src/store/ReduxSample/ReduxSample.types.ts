export interface UserSampleState {
  id: number;
  email: string;
  first_name: string;
  last_name: string;
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
