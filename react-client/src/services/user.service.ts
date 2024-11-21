import http from "../http-common";
import IUserData from "../types/user.type";

class UserDataService {
    getAll() {
        return http.get<Array<IUserData>>("/users");
    }
}

export default new UserDataService();
