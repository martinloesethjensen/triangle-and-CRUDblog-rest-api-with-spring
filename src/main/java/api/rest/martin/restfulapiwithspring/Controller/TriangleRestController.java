package api.rest.martin.restfulapiwithspring.Controller;

import api.rest.martin.restfulapiwithspring.Model.Triangle;
import api.rest.martin.restfulapiwithspring.Model.TriangleType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleRestController {

	/**
	 * There is assigned default values of -1 on all sides
	 * unless an query has been typed in the path of the url.
	 *
	 * @return ResponseEntity<TriangleType>
	 *
	 * @param a int and with a defaultValue of -1
	 * @param b int and with a defaultValue of -1
	 * @param c int and with a defaultValue of -1
	 * */
	@GetMapping("/api/triangle")
	public ResponseEntity<TriangleType> checkTriangleType(
			@RequestParam(defaultValue = "-1") int a,
			@RequestParam(defaultValue = "-1") int b,
			@RequestParam(defaultValue = "-1") int c)
	{
		Triangle triangle = new Triangle(a, b, c);

		return new ResponseEntity<>(triangle.getTriangleType(), HttpStatus.OK);
	}
}
