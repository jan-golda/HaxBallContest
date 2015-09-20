# HaxBallContest
Real time HaxBall like contest game

## Commands
| Command  | Response | Errors |
| -------- | ---------- | -------- | ------ |
| `LOGIN <username>` | `OK` | `200` `201` |
| `JOIN` | `OK` then `OK` | `300` |

## Errors
| Code  | Description |
| -----:| ----------- |
| `100` | internal server error |
| `101` | unknown error |
| `102` | unknown error |
| `103` | wrong syntax |
| `200` | user already connected |
| `201` | already logged in |
| `202` | authorization required |
| `300` | already in game |
