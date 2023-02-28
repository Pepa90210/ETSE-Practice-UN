import { useState } from "react";
// import { useDispatch } from "react-redux";
import { Login } from "../Login";

const LoginPage = () => {
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    // const dispatch = useDispatch();

    const onLogin = async (e) => {
        e.preventDefault();
        console.log("trying to submit");
        const data = await Login(userName, password);
        if (data.error) {
            setError(JSON.parse(data.error))
        }
    };

    return (
        <main>
            <section>
                <div className="loginContainer">
                    <form onSubmit={onLogin}>
                        <div>
                            <input
                                id="userName"
                                name="userName"
                                type="text"
                                value={userName}
                                required
                                onChange={(e) => setUserName(e.target.value)}
                            />
                            <span>username</span>
                        </div>
                        <div>
                            <input
                                id="password"
                                name="password"
                                type="password"
                                value={password}
                                required
                                onChange={(e) => setPassword(e.target.value)}
                            />
                            <span>password</span>
                        </div>
                        <button type="sibmit">Submit</button>
                        {error ?
                            (<div>
                                {error}
                            </div>)
                            :
                            null
                        }
                    </form>
                </div>
            </section>
        </main>
    );
};

export default LoginPage;
