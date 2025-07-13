class Solution {
    func matchPlayersAndTrainers(_ players: [Int], _ trainers: [Int]) -> Int {
        trainers
            .sorted()
            .reduce(0) { [sortedPlayers = players.sorted()] in
                $0 + ($1 >= (sortedPlayers.dropFirst($0).first ?? .max) ? 1 : 0)
            }
    }
}